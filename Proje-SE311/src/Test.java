//Evren Utku Güney
//Sýla Tekcan
//Gökay Gök
//Ceren Delibaþ
//Virus Tracking Application
import java.util.*;
import java.util.Date;

public class Test {
	public static void main(String args[]) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		Test test = new Test();
		runPrinterCommand runCommand = new runPrinterCommand();
		int choice;
		
		System.out.println("Creating a user...");
		Thread.sleep(1000);

		while (true) {
			System.out.println("" + "-------------------------------------------------------------------\n"
					+ "Press 1 if your phone is Iphone\n" + "Press 2 if your phone is Samsung\n"
					+ "Press 3 to print the names of users between the ages of 25 and 60\n"
					+ "Press 4 to print the three queries randomly\n" + "Press 5 to print the address\n"
					+ "Press 6 to count of the users");
			System.out.print("--> ");

			choice = scan.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Creating a user...");
				Thread.sleep(1000);
				System.out.println("Creating Iphone...");
				Thread.sleep(2000);
				PhoneMaker.getPhoneInstance().createIphoneUser();
				break;

			case 2:
				System.out.println("Creating a user...");
				Thread.sleep(1000);
				System.out.println("Creating Samsung...");
				Thread.sleep(2000);
				PhoneMaker.getPhoneInstance().createSamsungUser();
				break;

			case 3:
				System.out.println("Persons between ages 25-60: ");

				for (int i = 0; i < HealthMinistry.getHealthMinistry().getIphoneUsers().size(); i++) {
					if (HealthMinistry.getHealthMinistry().getIphoneUsers().get(i).readAge() < 60
							&& HealthMinistry.getHealthMinistry().getIphoneUsers().get(i).readAge() > 25) {
						System.out.println(HealthMinistry.getHealthMinistry().getIphoneUsers().get(i).readName());
					}
				}
				test.checkForUpdate(PhoneMaker.getPhoneInstance().typeChecker());

				for (int i = 0; i < HealthMinistry.getHealthMinistry().getSamsungUsers().size(); i++) {
					if (HealthMinistry.getHealthMinistry().getSamsungUsers().get(i).getAge() < 60
							&& HealthMinistry.getHealthMinistry().getSamsungUsers().get(i).getAge() > 25) {
						System.out.println(HealthMinistry.getHealthMinistry().getSamsungUsers().get(i).getName());
					}
				}
				test.checkForUpdate(PhoneMaker.getPhoneInstance().typeChecker());
				break;

			case 4:
				runCommand.printQuery();
				test.checkForUpdate(PhoneMaker.getPhoneInstance().typeChecker());
				break;

			case 5:
				System.out.println("Adress: ");
				for (int i = 0; i < HealthMinistry.getHealthMinistry().getIphoneUsers().size(); i++) {
					System.out.println(HealthMinistry.getHealthMinistry().getIphoneUsers().get(i).readAddress());
				}
				test.checkForUpdate(PhoneMaker.getPhoneInstance().typeChecker());
				for (int i = 0; i < HealthMinistry.getHealthMinistry().getSamsungUsers().size(); i++) {
					System.out.println(HealthMinistry.getHealthMinistry().getSamsungUsers().get(i).getAddress());
				}
				test.checkForUpdate(PhoneMaker.getPhoneInstance().typeChecker());
				break;

			case 6:
				System.out.println("Iphone users: " + HealthMinistry.getHealthMinistry().getIphoneUsers().size());
				System.out.println("Samsung users: " + HealthMinistry.getHealthMinistry().getSamsungUsers().size());
				System.out.println("Total users: " + (HealthMinistry.getHealthMinistry().getIphoneUsers().size()
						+ HealthMinistry.getHealthMinistry().getSamsungUsers().size()));
				test.checkForUpdate(PhoneMaker.getPhoneInstance().typeChecker());
				break;

			default:
				break;
			}
		}
	}

	public void checkForUpdate(boolean checker) {
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();

		if (checker) {
			int last = HealthMinistry.getHealthMinistry().getIphoneUsers().size();
			Calendar timeOfUserDate = HealthMinistry.getHealthMinistry().getIphoneUsers().get(last - 1).getCalendar();
			timeOfUserDate.add(Calendar.SECOND, 20);

			if (now.after(timeOfUserDate.getTime())) {
				ConditionInfoObserver conditionInfo = new ConditionInfoObserver();
				new IphoneObserver(conditionInfo);
				System.out.println("Please update your information");
				conditionInfo.setState("iphone");
			}
		} else {
			int last = HealthMinistry.getHealthMinistry().getSamsungUsers().size();
			Calendar timeOfUserDate = HealthMinistry.getHealthMinistry().getSamsungUsers().get(last - 1).getCalendar();
			timeOfUserDate.add(Calendar.SECOND, 20);

			if (now.after(timeOfUserDate.getTime())) {
				ConditionInfoObserver conditionInfo = new ConditionInfoObserver();
				new SamsungObserver(conditionInfo);
				System.out.println("Please update your information");
				conditionInfo.setState("samsung");
			}
		}
	}
}