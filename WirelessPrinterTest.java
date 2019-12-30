package hw1;

import java.util.Random;

public class WirelessPrinterTest {
	public static void main(String[] args) {
		WirelessPrinter printer = new WirelessPrinter(1.0, 500);
		int seed = 0;
		
		// try turn it on and test its wireless connection 
		printer.turnOn();
		System.out.println(printer.isOn()); // expected true
		System.out.println(printer.isConnected()); // expected true
		System.out.println(printer.getPaperLevel()); // expected 100
		System.out.println(printer.getInkLevel()); // expected 1.0
		
		// try print
		printer.print(50);
		System.out.println(printer.getPaperLevel()); // expected 90
		System.out.println(printer.getInkLevel()); // expected 0.95
		System.out.println(printer.getTotalPagesPrinted()); // expected 50
		System.out.println(printer.getTotalPaperUsed()); // expected 50
		
		// try print more pages than what is left in the tray
		printer.print(500); // out of paper
		System.out.println(printer.getPaperLevel()); // expected 0
		System.out.println(printer.getInkLevel());   // expected 0.5
		System.out.println(printer.getTotalPagesPrinted()); // expected 500
		System.out.println(printer.getTotalPaperUsed());  // expected 500
		
		// try loadPaper method
		printer.loadPaper(1000);
		System.out.println(printer.getPaperLevelExact()); // expected 500
		
		
		// try replace the cartridge
		printer.replaceCartridge();
		System.out.println(printer.getInkLevel());   // expected 1.0
		
		// try disconnect method
		printer.disconnect(); // network goes off
	    printer.print(50);
		System.out.println(printer.getPaperLevelExact()); // expected 500
		System.out.println(printer.getInkLevel());   // expected 1.0
	}
}