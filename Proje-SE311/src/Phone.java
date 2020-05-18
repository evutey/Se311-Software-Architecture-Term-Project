//Evren Utku Güney
//Sýla Tekcan
//Gökay Gök
//Ceren Delibaþ
//Virus Tracking Application
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class Phone {

	protected String name;
	protected String address;
	protected int age;
	protected double fever;
	protected String muscleAche;
	protected String runnyNose;
	protected Calendar time;
	protected String number;

	public abstract void receive();

	public abstract void send();

	// template method
	public final void takeInfo() {
		receive();
		send();
	}

	public void printAdress() {
		System.out.println("Address of the last registered person: " + getAddress()+"\n");
	}

	public void printGetConditionInfo() {
		System.out.println("Condition information of the last registered person");
		System.out.println("Fever: " + getFever());
		System.out.println("Muscle ache: " + getMuscleAche());
		System.out.println("Runny nose: " + getRunnyNose());
		System.out.println("Time: " + getTime()+"\n");
	}

	public void printTime() {
		System.out.println("Time of the last registered person: " + getTime()+"\n");
	}

	public String getAddress() {
		return address;
	}

	public double getFever() {
		return fever;
	}

	public String getMuscleAche() {
		return muscleAche;
	}

	public String getRunnyNose() {
		return runnyNose;
	}

	public Date getTime() {
		return time.getTime();
	}

	public Calendar getCalendar() {
		return time;
	}
}

class PhoneMaker {

	private static volatile PhoneMaker phoneInstance = new PhoneMaker();
	private static IphoneUser iphone;
	private SamsungUser samsung;
	private boolean isIphone;

	private PhoneMaker() {
		iphone = new IphoneUser();
		samsung = new SamsungUser();
	}

	public static PhoneMaker getPhoneInstance() {
		return phoneInstance;
	}

	public IphoneUser getIphone() {
		return iphone;
	}

	public void getConditionInfo(String state) {
		if (state.equals("iphone")) {
			iphone.conditionInfoIphone();
		} else {
			samsung.conditionInfoSamsung();
		}
	}

	public void getReceive(String state) {
		if (state.equals("iphone")) {
			iphone.receive();
		} else {
			samsung.receive();
		}
	}

	public void createIphoneUser() {
		isIphone = true;
		iphone.send();
		HealthMinistry.getHealthMinistry().getIphoneUsers().add(iphone);
		HealthMinistry.getHealthMinistry().getPhones().add(iphone);
		iphone.receive();
	}

	public void createSamsungUser() {
		isIphone = false;
		samsung.send();
		HealthMinistry.getHealthMinistry().getSamsungUsers().add(samsung);
		HealthMinistry.getHealthMinistry().getPhones().add(samsung);
		samsung.receive();
	}

	public void createPhoneUser(String state) {
		if (state.equals("iphone")) {
			iphone.conditionInfoIphone();
			iphone.receive();
		} else {
			samsung.conditionInfoSamsung();
			samsung.receive();
		}
	}

	public boolean typeChecker() {
		return isIphone;
	}
}

interface Library {

	void receive();

	void send();
}

class IphoneUser extends Phone implements Library {

	Scanner input = new Scanner(System.in);

	public void receive() {
		System.out.println("\nName: " + readName());
		System.out.println("Number: " + readNumber());
		System.out.println("Address: " + readAddress());
		System.out.println("Age: " + readAge());
		System.out.println("Fever: " + readFever());
		System.out.println("MuscleAche: " + readMuscleAche());
		System.out.println("RunnyNose: " + readRunnyNose());
		System.out.println("Time: " + readTime());
	}

	public void send() {

		demogroficInfoIphone();
		conditionInfoIphone();
	}

	public void demogroficInfoIphone() {

		System.out.print("Please enter your number: ");
		String number = input.next();
		writeNumber(number);

		System.out.print("Please enter your name: ");
		String name = input.next();
		writeName(name);

		System.out.print("Please enter your age: ");
		int age = input.nextInt();
		writeAge(age);

		System.out.print("Please enter your address: ");
		String address = input.next();
		writeAddress(address);
	}

	public void conditionInfoIphone() {

		System.out.print("Please enter your fever: ");
		double fever = input.nextDouble();
		writeFever(fever);

		System.out.print("Do you have muscle ache (yes or no): ");
		String muscleAche = input.next();
		writeMuscleAche(muscleAche);

		System.out.print("Do you have runny nose (yes or no): ");
		String runnyNose = input.next();
		writeRunnyNose(runnyNose);

		writeTime(Calendar.getInstance());
	}

	public IphoneUser(String name, String address, int age, double fever, String muscleAche, String runnyNose,
			Calendar time) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.fever = fever;
		this.muscleAche = muscleAche;
		this.runnyNose = runnyNose;
		this.time = time;
	}

	public IphoneUser() {
	}

	public String readName() {
		return name;
	}

	public void writeName(String name) {
		this.name = name;
	}

	public String readAddress() {
		return address;
	}

	public void writeAddress(String address) {
		this.address = address;
	}

	public int readAge() {
		return age;
	}

	public void writeAge(int age) {
		this.age = age;
	}

	public double readFever() {
		return fever;
	}

	public void writeFever(double fever) {
		this.fever = fever;
	}

	public String readMuscleAche() {
		return muscleAche;
	}

	public void writeMuscleAche(String muscleAche) {
		this.muscleAche = muscleAche;
	}

	public String readRunnyNose() {
		return runnyNose;
	}

	public void writeRunnyNose(String runnyNose) {
		this.runnyNose = runnyNose;
	}

	public Date readTime() {
		return time.getTime();
	}

	public void writeTime(Calendar time) {
		this.time = time;
	}

	public String readNumber() {
		return number;
	}

	public void writeNumber(String number) {
		this.number = number;
	}
}

class SamsungUser extends Phone implements Library {
	Scanner input = new Scanner(System.in);

	public void receive() {
		System.out.println("Name: " + getName());
		System.out.println("Number: " + getNumber());
		System.out.println("Address: " + getAddress());
		System.out.println("Age: " + getAge());
		System.out.println("Fever: " + getFever());
		System.out.println("MuscleAche: " + getMuscleAche());
		System.out.println("RunnyNose: " + getRunnyNose());
		System.out.println("Time: " + getTime());
	}

	public void send() {

		demogroficInfoSamsung();
		conditionInfoSamsung();
	}

	public void demogroficInfoSamsung() {

		System.out.print("Please enter your number: ");
		String number = input.next();
		setNumber(number);

		System.out.print("Please enter your name: ");
		String name = input.next();
		setName(name);

		System.out.print("Please enter your age: ");
		int age = input.nextInt();
		setAge(age);

		System.out.print("Please enter your address: ");
		String address = input.next();
		setAddress(address);
	}

	public void conditionInfoSamsung() {

		System.out.print("Please enter your fever: ");
		double fever = input.nextDouble();
		setFever(fever);

		System.out.print("Do you have muscle ache(Yes or No): ");
		String muscleAche = input.next();
		setMuscleAche(muscleAche);

		System.out.print("Do you have runny nose(Yes or No): ");
		String runnyNose = input.next();
		setRunnyNose(runnyNose);

		setTime(Calendar.getInstance());
	}

	public SamsungUser(String name, String address, int age, double fever, String muscleAche, String runnyNose,
			Calendar time) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.fever = fever;
		this.muscleAche = muscleAche;
		this.runnyNose = runnyNose;
		this.time = time;
	}

	public SamsungUser() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getFever() {
		return fever;
	}

	public void setFever(double fever) {
		this.fever = fever;
	}

	public String getMuscleAche() {
		return muscleAche;
	}

	public void setMuscleAche(String muscleAche) {
		this.muscleAche = muscleAche;
	}

	public String getRunnyNose() {
		return runnyNose;
	}

	public void setRunnyNose(String runnyNose) {
		this.runnyNose = runnyNose;
	}

	public Date getTime() {
		return time.getTime();
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}