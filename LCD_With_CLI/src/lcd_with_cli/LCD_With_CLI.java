/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcd_with_cli;

/**
 *
 * @author Kareem
 */

import com.pi4j.component.lcd.impl.I2CLcdDisplay;
import com.pi4j.io.i2c.I2CBus;
import java.util.Scanner;

public class LCD_With_CLI {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        I2CLcdDisplay lcd = new I2CLcdDisplay(4, 20, I2CBus.BUS_1, 0x27, 3, 0, 1, 2, 7, 6, 5, 4);
        
	lcd.setBacklight(true);  //LCD Backlight enable
	lcd.clear(); //LCD Clear
                
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);
		
		while(true){
                    
                    //  prompt for the cursor position row number
                    System.out.print("Enter the Cursor Position Row Number: ");
                    // get the row as int
                    int row = scanner.nextInt();
        
                    //  prompt for the cursor position column number
                    System.out.print("Enter the Cursor Position Column Number: ");
                    // get the col as int
                    int col = scanner.nextShort();
                    
                    //  prompt for the column
                    System.out.print("Enter the Phrase: ");
                    // get the pharse as string
                    String Phrase = scanner.next(); 
                            
                    lcd.clear(); //LCD Clear
                    lcd.setCursorPosition(row, col);
                    lcd.write(Phrase);
			
		}   //While     
    }
    
} //Class
