package src;

import src.handleDb.createDb.CreateLooproadDb;
import src.handleDb.getData.HandleTopo;

public class MainLooproadFromTopo {

	/**
	 * トポロジから周回道路の作成
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HandleTopo handleTopo = new HandleTopo();
		CreateLooproadDb createLooproadDb = new CreateLooproadDb();
		handleTopo.startConnection();
		createLooproadDb.startConnection();
		createLooproadDb.createTable();
		
		
		int faceNum = handleTopo.getFaceNum();
		
		for(int i=0+1; i<faceNum+1; i++){	// フェイスIDは１から.
			String looproadPolyString = handleTopo.getLooproadString(i);
			createLooproadDb.insertLooproadData(looproadPolyString);
			if(i % 1000 == 0){
				System.out.println(i +"/"+faceNum);
			}
		}
		
		
		
		handleTopo.endConnection();
		createLooproadDb.endConnection();
		
	}

}
