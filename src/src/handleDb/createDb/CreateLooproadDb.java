package src.handleDb.createDb;

import java.sql.ResultSet;

import src.handleDb.HandleDbTemplateSuper;

/**
 * 周回道路DBを作成する
 * @author murase
 *
 */
public class CreateLooproadDb extends HandleDbTemplateSuper{
//	private static final String DBNAME = "osm_looproad_db";	// Database Name
	private static final String DBNAME = "osm_road_db";
	private static final String SCHEMA = "looproad";
	private static final String TBNAME = "looproad_geom";	
	private static final String TOPO_NAME = "topo_tb";	
	private static final String USER = "postgres";			// user name for DB.
	private static final String PASS = "usadasql";		// password for DB.
	private static final String URL = "rain2.elcom.nitech.ac.jp";
	private static final int PORT = 5432;
	private static final String DBURL = "jdbc:postgresql://"+URL+":"+PORT+"/" + DBNAME;

	public CreateLooproadDb(){
		super(DBNAME, USER, PASS, DBURL, HandleDbTemplateSuper.POSTGRESJDBCDRIVER_STRING);
	}
	
	
	/**
	 * テーブル作成
	 */
	public void createTable(){
		try{
			String statement="";
			statement += "create table "+SCHEMA+"."+TBNAME+"(LR_id serial primary key, geom geometry(polygon, "+WGS84_EPSG_CODE+"));";
			statement += " create index "+SCHEMA+"_"+TBNAME+"_geom on "+SCHEMA+"."+TBNAME+" using gist(geom); ";
			System.out.println(statement);
			insertInto(statement);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * データの格納
	 */
	public void insertLooproadData(String geom){
		try{
			String statement="";
			statement = "insert into "+SCHEMA+"."+TBNAME+" (geom) values(st_geomFromText('"+geom+"',"+WGS84_EPSG_CODE+"))";
//			System.out.println(statement);
			insertInto(statement);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
}
