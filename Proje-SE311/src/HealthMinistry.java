//Evren Utku Güney
//Sýla Tekcan
//Gökay Gök
//Ceren Delibaþ
//Virus Tracking Application
import java.util.ArrayList;

public class HealthMinistry {

	private ArrayList<Phone> phones = new ArrayList<Phone>();
	private ArrayList<IphoneUser> iphoneUsers = new ArrayList<IphoneUser>();
	private ArrayList<SamsungUser> samsungUsers = new ArrayList<SamsungUser>();
	private static volatile HealthMinistry instance = new HealthMinistry();

	private HealthMinistry() {
	}

	public static HealthMinistry getHealthMinistry() {

		return instance;
	}

	public ArrayList<Phone> getPhones() {
		return phones;
	}

	public ArrayList<IphoneUser> getIphoneUsers() {
		return iphoneUsers;
	}

	public ArrayList<SamsungUser> getSamsungUsers() {
		return samsungUsers;
	}
}