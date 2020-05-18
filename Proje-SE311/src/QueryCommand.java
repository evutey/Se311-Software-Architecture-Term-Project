//Evren Utku Güney
//Sýla Tekcan
//Gökay Gök
//Ceren Delibaþ
//Virus Tracking Application
import java.security.SecureRandom;

public interface QueryCommand {
	public void printQuery();
}

class PrinterController {
	QueryCommand queryCommand;

	public void setQueryCommand(QueryCommand queryCommand) {
		this.queryCommand = queryCommand;
	}

	public void clickPrint() {
		queryCommand.printQuery();
	}
}

class printerForQuery {
	public void print() {
		SecureRandom random = new SecureRandom();

		if (getRandom()) {
			printLocation(random.nextInt(HealthMinistry.getHealthMinistry().getPhones().size()));
		}

		if (getRandom()) {
			printConditionInfo(random.nextInt(HealthMinistry.getHealthMinistry().getPhones().size()));
		}

		if (getRandom()) {
			printTime(random.nextInt(HealthMinistry.getHealthMinistry().getPhones().size()));
		}
	}

	public void printLocation(int randomInteger) {

		HealthMinistry.getHealthMinistry().getPhones().get(randomInteger).printAdress();
	}

	public void printConditionInfo(int randomInteger) {

		HealthMinistry.getHealthMinistry().getPhones().get(randomInteger).printGetConditionInfo();
	}

	public void printTime(int randomInteger) {

		HealthMinistry.getHealthMinistry().getPhones().get(randomInteger).printTime();
	}

	public boolean getRandom() {
		SecureRandom randomQuery = new SecureRandom();
		if (randomQuery.nextInt(2) == 1) {
			return true;
		}

		else {
			return false;
		}
	}
}

class runPrinterCommand implements QueryCommand {
	printerForQuery printer = new printerForQuery();

	public runPrinterCommand(printerForQuery printer) {
		super();
		this.printer = printer;
	}

	public runPrinterCommand() {
	}

	public void printQuery() {
		System.err.println("\nRandom query printed");
		printer.print();
	}
}