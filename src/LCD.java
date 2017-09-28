/*
 * @author Jaden Foldesi <flodesi57@gmail.com>
 * This is a brief program to introduce the LCD display and control it via the GPIO
*/
import com.pi4j.component.lcd.impl.GpioLcdDisplay;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;

public class LCD {

	public final static int TopRow = 0;
	public final static int BottomRow = 1;

	public static void main(String[] args) throws Exception {

		final GpioController gpio = GpioFactory.getInstance();

		//GpioLcdDisplay(#of rows, # of columns, GPIO pin for RS, GPIO pin for strobe, followed by the 4 data pins)
		final GpioLcdDisplay lcd = new GpioLcdDisplay(2, 16, RaspiPin.GPIO_29,
				RaspiPin.GPIO_25, RaspiPin.GPIO_24, RaspiPin.GPIO_23,
				RaspiPin.GPIO_22, RaspiPin.GPIO_21);
		//clear the LCD display
		lcd.clear();
		Thread.sleep(1000);
		//outp Hello world and nice to meet you on the top and bottom rows
		lcd.write(TopRow, "Hello World!");
		lcd.write(BottomRow, "Nice to Meet You");

		gpio.shutdown();
	}
}
