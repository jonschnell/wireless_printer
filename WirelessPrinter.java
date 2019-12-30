package hw1;

/**
 * 
 * @author Jonathon Schnell
 * @version 1.0
 * @since 9-18-2019
 * COM S 227
 * homework1
 *
 */

public class WirelessPrinter {
	/**
	 * PAGES_PER_CARTRIDGE PUBLIC is 100, each cartridge has 1000 pages
	 */
	public static final int PAGES_PER_CARTRIDGE = 1000;
	/**
	 * TRAY_CAPACITY PUBLIC is the amounts of pages that can be printed with a NEW_CARTRIDGE
	 */
	public static final int TRAY_CAPACITY = 500;
	/**
	 * NEW_CARTRIDGE_INK_LEVEL PUBLIC is 1.0 or 100% ink in the cartridge
	 */
	public static final double NEW_CARTRIDGE_INK_LEVEL = 1.0;
	
	/**
	 * CARTRIDGE_INK_LEVEL PRIVATE working memory of ink level if 50 pages are printed ink level will be .95
	 */
	private double CARTRIDGE_INK_LEVEL=0;
	/**
	 * PRIVATE On denotes if printer is turned on
	 */
	private boolean On = false;
	/**
	 * PRIVATE Connected denoted of the printer is connected to the computer
	 */
	private boolean Connected = false;
	/**
	 * PRIVATE paperlevel working memory of paper level in printer, the number of pages left in the printer tray
	 */
	private int paperlevel=0;
	/**
	 * PRIVATE pagesprinted denotes the amount of pages that have been printed since the tray way refilled
	 */
	private int pagesprinted=0;
	/**
	 * PRIVATE paperPercentage the amount of paper left in the tray as a percentage. paperlevel/PAGES_PER_CARTRIDGE
	 */
	private int paperPercentage=0;
	/**
	 * PRIVATE cartridgePercentage is the percentage of ink left in the carteidge or ink/NEW_CARTRIDGE_INK_LEVEL
	 */
	private int carteidgePercentage=0;
	/**
	 * created a wireless printer with half full ink cartridge CARTRIDGE_INK_LEVEL = 0.5
	 */
	public WirelessPrinter() {
		CARTRIDGE_INK_LEVEL = 0.5;

	}
	/**
	 * creates printer with
	 * @param ink set CARTRIDGE_INK_LEVEL
	 * @param paper set paperlevel
	 */
	public WirelessPrinter(double ink, int paper) {
		this.paperlevel = paper;
		this.CARTRIDGE_INK_LEVEL = ink;
	}
	
	/**
	 * turns printer on and connects printer
	 */
	public void turnOn() {
		On = true;
		Connected = true;
	}
	
	/**
	 * turn printer off
	 */
	public void turnOff() {
		On = false;
	}
	/**
	 * turns pinter on
	 * @return on boolean
	 */
	public boolean isOn() {
		return On;
	}
	/**
	 * connects printer
	 */
	public void connect() {
		Connected = true;
	}
	/**
	 * checks if printer is connected
	 * @return connected
	 */
	public boolean isConnected() {
		return Connected;
	}
	/**
	 * disconnects printer
	 */
	public void disconnect() {
		Connected = false;
	}
	/**
	 * 
	 * @return paperPercentage paper remaining in printer in percentage
	 */
	public int getPaperLevel() {
		paperPercentage = (int)((paperlevel*1.0/TRAY_CAPACITY)*100);
		return paperPercentage;
	}
	/**
	 * 
	 * @return CARTRIDGE_INK_LEVEL the amount of ink left in the printer
	 */
	public double getInkLevel() {
		
		return CARTRIDGE_INK_LEVEL;
	}
	/**
	 * 
	 * @param i number of pages being printed
	 * only prints if pinter is connected and on
	 * decrements paper and ink using a for loop
	 * only decrements if there is paper and ink in the printer
	 * 
	 */
	public void print(int i) {
		if (isOn()&&isConnected()) {
			for (int k=0; k<i; k++) {
				if (paperlevel > 0&&CARTRIDGE_INK_LEVEL > 0) {
				paperlevel = paperlevel-1;
				pagesprinted = pagesprinted+1;
				CARTRIDGE_INK_LEVEL = CARTRIDGE_INK_LEVEL - (1.0/PAGES_PER_CARTRIDGE);
				}
				else {
					System.out.println("out of paper or ink");
					return;
				}
			}
		}else {
			System.out.println("system not connected");
		}
	}
	/**
	 * gets total pages printed
	 * @return pagesprinted total number of pages printed since power on
	 */
	public int getTotalPagesPrinted() {

		return pagesprinted;
	}
	/**
	 * gets total paper used
	 * @return pagesprinted
	 */
	public int getTotalPaperUsed() {

		return pagesprinted;
	}
	/**
	 * loads i pages into the printer
	 * @param i pages to be printed
	 */
	public void loadPaper(int i) {
		if(paperlevel+i>500) {
			paperlevel = 500;
		}else {
		paperlevel=paperlevel+i;
		}
	}
	/**
	 * gets exact paper level in printer
	 * @return paperlevel
	 */
	public int getPaperLevelExact() {

		return paperlevel;
	}
	/**
	 * replaces ink cartridge sets CARTRIDGE_INK_LEVEL to NEW_CARTRIDGE_INK_LEVEL
	 */
	public void replaceCartridge() {
		CARTRIDGE_INK_LEVEL = NEW_CARTRIDGE_INK_LEVEL;
	}
}
