package src.handleDb.getData;

import java.sql.ResultSet;

import src.handleDb.HandleDbTemplateSuper;

/**
 * トポロジを扱う
 * @author murase
 *
 */
public class HandleTopo extends HandleDbTemplateSuper{
	private static final String DBNAME = "osm_road_topo_db";	// Database Name
	private static final String TBNAME = "";	
	private static final String TOPO_NAME = "topo_tb";	
	private static final String USER = "postgres";			// user name for DB.
	private static final String PASS = "usadasql";		// password for DB.
	private static final String URL = "rain2.elcom.nitech.ac.jp";
	private static final int PORT = 5432;
	private static final String DBURL = "jdbc:postgresql://"+URL+":"+PORT+"/" + DBNAME;
	
	
	public HandleTopo() {
		super(DBNAME, USER, PASS, DBURL, HandleDbTemplateSuper.POSTGRESJDBCDRIVER_STRING);
	}
	
	
	/**
	 * フェイス数を取得する(0を除く)
	 */
	public int getFaceNum(){
		int faceNum=0;
		try{
			String stmt = "";
			stmt = "select count(*) from topo_tb.face";
			System.out.println(stmt);
			ResultSet rs = execute(stmt);
			while(rs.next()){
				faceNum = rs.getInt(1) - 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return faceNum;
	}
	
	/**
	 * フェイスIDを指定してそのポリゴンのstringを返す
	 * @return
	 */
	public String getLooproadString(int aFaceId){
		String geomString = "";
		
		try{
			String statement="";
			statement += "select st_asText(st_getFaceGeometry('"+TOPO_NAME+"', "+aFaceId+"))";
//			System.out.println(statement);
			ResultSet rs = executeTopo(statement);
			while(rs.next()){
				geomString = rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}

		
		return geomString;
	}
	
	
}
