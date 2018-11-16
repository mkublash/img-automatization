package tbc.leasing.img;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int x = 0;
        int y = 0;

        String card = "";
        String barCode = "";
        String saveFolder = "";

        while (true) {


            System.out.println("Enter Position for X  use (" + x + ") press y");

            if (!sc.next().equals("y")) {
                x = sc.nextInt();
            }

            System.out.println("Enter Position for Y use (" + y + ") press y");
            if (!sc.next().equals("y")) {
                y = sc.nextInt();
            }
//        "/home/dchkhartishvili/qr/card.jpeg"
            // card file check
            System.out.println("Enter Card Picture use (" + card + ") press enter");
            if (!sc.next().equals("y")) {
                card = sc.next();
            }
            File fileCard = new File(card);

            if (!fileCard.exists() && !fileCard.isFile()) {
                throw new RuntimeException("Background image not found");
            }

            System.out.println("Enter Barcode Source folder (" + barCode + ") press enter");
            if (!sc.next().equals("y")) {
                barCode = sc.next();
            }
            File dirFront = new File(barCode);
            if (!dirFront.exists() && !dirFront.isDirectory()) {
                throw new RuntimeException("Front image directory not found");
            }

            System.out.println("Enter Folder where you want to save (" + saveFolder + ") press enter");
            if (!sc.next().equals("y")) {
                saveFolder = sc.next();
            }
            File dirOutput = new File(saveFolder);
            if (!dirOutput.exists() && !dirOutput.isDirectory()) {
                throw new RuntimeException("Output Dir not found");
            }


            File[] frontFiles = dirFront.listFiles();

            for (File frontFile : frontFiles) {


                BufferedImage sourceBuffered = ImageIO.read(fileCard);
                BufferedImage frontBuffered = ImageIO.read(frontFile);


                File output = new File(dirOutput, frontFile.getName());

                System.out.println("START PROCESSING FILE " + frontFile.getName());

                ImageMerger.merge(sourceBuffered, frontBuffered, x, y,260,260, output);

                System.out.println("CONVERETED " + output.getAbsolutePath());

            }

            System.out.println("CONVERSION FINISHED ! ");
            System.out.println("Exit Program y/n");
            String exit = sc.next();

            if (exit.equals("y")) {
                break;
            }
        }

    }
}
