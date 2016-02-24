# 概要
トポロジーデータから周回道路を作成

## 設定
/src/src/createDb/CreateLooproadDb.javaにDBの作成先の情報を書いてください

``` java:
	private static final String DBNAME = "osm_road_db";
	private static final String SCHEMA = "looproad";
	private static final String TBNAME = "looproad_geom";	
	private static final String TOPO_NAME = "topo_tb";	
	private static final String USER = "postgres";			// user name for DB.
	private static final String PASS = "usadasql";		// password for DB.
	private static final String URL = "各自の環境に合わせてDBの設定してください";//"localhost","rain2.elcom.nitech.ac.jp";
	private static final int PORT = 5432;
	private static final String DBURL = "jdbc:postgresql://"+URL+":"+PORT+"/" + DBNAME;
```
