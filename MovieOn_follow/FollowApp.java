package MovieOn_follow;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import orm.DeptDAOImpl;

public class FollowApp {
	
	public static void main(String[] args) {
		
		
		FollowDAOImpl dao = new FollowDAOImpl();
		
		//CREATE!!!!!!!!!!!!!!!!!!!!	      		
		FollowVO vo1 = new FollowVO(2, 3);    //把時戳的程式移到後台，前台只需要指定相關對象			
		dao.create(vo1);
		System.out.println("new follow created");
		
		
		//UPDATE!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		FollowVO vo2 = new FollowVO();
		vo2.setFollowID(5);
		vo2.setSourceID(3);
		vo2.setTargetID(2);
		dao.update(vo2);
		System.out.println("follow edited");

		
		//DELETE
//		dao.deleteByID(4);

		
		//FINDBYID		
		FollowVO vo3 = dao.findByID(1);
		int followID3 = vo3.getFollowID();
		int sourceID3 = vo3.getSourceID();
		int targetID3 = vo3.getTargetID();
		String updatedAt3 = vo3.getUpdatedAt();
		
		System.out.println("Details for Follow ID " + followID3 + ":");
		System.out.println("Source user: " + sourceID3);
		System.out.println("Target user: " + targetID3);
		System.out.println("Follow updated at: " + updatedAt3);

		
		//FINDALL
		List<FollowVO> list1 = dao.findAll();
		
		for (FollowVO vo4 : list1) {
			int followID4 = vo4.getFollowID();
			int sourceID4 = vo4.getSourceID();
			int targetID4 = vo4.getTargetID();
			String updatedAt4 = vo4.getUpdatedAt();
			
			System.out.println("Details for Follow ID " + followID4 + " -");
			System.out.println("Source user: " + sourceID4);
			System.out.println("Target user: " + targetID4);
			System.out.println("Follow updated at: " + updatedAt4);
			System.out.println("========================================");
		}


		//FINDBYSOURCE
		int findThisSource = 1;
		
		List<FollowVO> list2 = dao.findBySource(findThisSource);
	
		System.out.println("Showing all users followed by this user ( " + findThisSource + " ) -");

		for (FollowVO vo5 : list2) {
			int followID5 = vo5.getFollowID();
			int sourceID5 = vo5.getSourceID();
			int targetID5 = vo5.getTargetID();
			String updatedAt5 = vo5.getUpdatedAt();
			
			System.out.println("========================================");
			System.out.println("Follow ID: " + followID5);
			System.out.println("Source user: " + sourceID5);
			System.out.println("Target user: " + targetID5);
			System.out.println("Follow updated at: " + updatedAt5);
			System.out.println("========================================");
		}
		

		//FINDBYTARGET
		int findThisTarget = 3;
		
		List<FollowVO> list3 = dao.findByTarget(findThisTarget);
		
		System.out.println("Showing all users following this user ( " + findThisTarget + " ) -");

		for (FollowVO vo6 : list3) {
			int followID6 = vo6.getFollowID();
			int sourceID6 = vo6.getSourceID();
			int targetID6 = vo6.getTargetID();
			String updatedAt6 = vo6.getUpdatedAt();
			
			System.out.println("========================================");
			System.out.println("Follow ID: " + followID6);
			System.out.println("Source user: " + sourceID6);
			System.out.println("Target user: " + targetID6);
			System.out.println("Follow updated at: " + updatedAt6);
			System.out.println("========================================");
		}
		

	
	
	}
	
}
