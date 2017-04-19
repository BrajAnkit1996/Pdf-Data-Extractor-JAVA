/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vishakha;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.CryptographyException;

/**
 *
 * @author MMI
 */
public class Vishakha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, CryptographyException, COSVisitorException {
         String token1 = "";
    String token2 = "";
    String token3 = "";
    
    System.out.println("Enter the file path :");
    Scanner user_input = new Scanner(System.in);

    String file_address;
    file_address = user_input.next();//"....Get file address...."
    System.out.println(file_address);

    File folder = new File(file_address);
    File[] listOfFiles = folder.listFiles();
    for (int i = 0; i < listOfFiles.length; i++)
    {
        if (listOfFiles[i].isFile())
        {
            String file_name = listOfFiles[i].getName();
            //System.out.println(file_name);

            PDFManager pdfManager = new PDFManager();
            File f = new File(file_address + "" + file_name);
            String fname = f.getName();
            String filename = fname.replace(".pdf", "");
            pdfManager.setFilePath(file_address + "" + file_name);

            String text = pdfManager.ToText();
            try
            {
                File newTextFile = new File("D:\\Braj_Ankit\\PDFDATA\\visakhakha\\West\\" + filename + ".txt");//"..Chnage folder name.."
                FileWriter fw = new FileWriter(newTextFile);
                fw.write(text);
                fw.close();
            } catch (Exception e) {System.out.println("Exception1 :"+e);}
            
           /*try 
            {
                File newTextFile1 = new File("D:\\Braj_Ankit\\PDFDATA\\visakhakha\\West\\output.csv");//"..Change folder name.."
                FileWriter fw1 = new FileWriter(newTextFile1);
                fw1.write("Part No.;Polling Address;Polling Name;Main Town;police Station;Mandal;Revenue Division;District;Pincode;Elector's Name;Father's/Husband Name;House No.;EPIC No.");
                fw1.write("\n");
                fw1.close();
            } catch (Exception e) {System.out.println("Exception2 :"+e);}*/
            
            Scanner fileIn = new Scanner(new File("D:\\Braj_Ankit\\PDFDATA\\visakhakha\\West\\" + filename + ".txt"));//"..Change folder name.."
            try
            {
                File file = new File("D:\\Braj_Ankit\\PDFDATA\\visakhakha\\West\\output.csv");//"..Change folder Name.."
                FileWriter writer;

                writer = new FileWriter(file, true);
                PrintWriter printer = new PrintWriter(writer);
                    
                while(fileIn.hasNextLine())
                {
                    String token = fileIn.nextLine();
                    //System.out.println("Token :"+token);
                    if(token.startsWith("Net Electors"))
                    {
                        int num = 1;
                        HashMap<Integer,String> hm = new HashMap<Integer,String>();
                        while(num<=3)
                        {
                            hm.put(num, fileIn.nextLine());
                            num++;
                        }
                        for(Map.Entry m:hm.entrySet())
                        {
                            //System.out.println(m.getKey()+" "+m.getValue());
                        }
                        String polling_address = hm.get(2)+hm.get(3);
                        //System.out.println("Polling Address :"+polling_address);
                        String b = "";
                        String part_num = filename;
                        printer.append(part_num+";"+polling_address);
                        printer.append("\n");
                    }
                    if(token.startsWith("deletions and corrections"))
                    {
                        int num =1;
                        HashMap<Integer,String> hm = new HashMap<Integer,String>();
                        while(num<=2)
                        {
                            hm.put(num, fileIn.nextLine());
                            num++;
                        }
                        for(Map.Entry m:hm.entrySet())
                        {
                            //System.out.println(m.getKey()+" "+m.getValue());
                        }
                        String polling_name = hm.get(2);
                        //System.out.println("Polling Name :"+polling_name);
                        String b = "";
                        printer.append(b+";"+b+";"+polling_name);
                        printer.append("\n");
                    }
                    if(token.startsWith("Third Gender"))
                    {
                        int num = 1;
                        HashMap<Integer,String> hm = new HashMap<Integer,String>();
                        while(num<=7)
                        {
                            hm.put(num, fileIn.nextLine());
                            num++;
                        }
                        for(Map.Entry m:hm.entrySet())
                        {
                            //System.out.println(m.getKey()+" "+m.getValue());
                        }
                        String main_town = hm.get(2);
                        String district = hm.get(3);
                        String revenue_division = hm.get(4);
                        String mandal = hm.get(5);
                        String pincode = hm.get(6);
                        String police_station = hm.get(7);
//                        System.out.println("Main Town :"+main_town);
//                        System.out.println("District :"+district);
//                        System.out.println("Revenue Division :"+revenue_division);
//                        System.out.println("Mandal :"+mandal);
//                        System.out.println("Pincode :"+pincode);
//                        System.out.println("Police Station :"+police_station);
                        String b = "";
                        printer.append(b+";"+b+";"+b+";"+main_town+";"+police_station+";"+mandal+";"+revenue_division+";"+district+";"+pincode);
                        printer.append("\n");
                    }
                    if(token.startsWith("House No:"))
                    {
                        int num = 1;
                        HashMap<Integer,String> hm = new HashMap<Integer,String>();
                        while(num<=6)
                        {
                            hm.put(num, fileIn.nextLine());
                            num++;
                        }
                        for(Map.Entry m:hm.entrySet())
                        {
                            //System.out.println(m.getKey()+" "+m.getValue());
                        }
                        String elc_name = hm.get(5);
                        String hus = hm.get(6);
                        String house_num = hm.get(3);
                        String epic_num = hm.get(1);
//                        System.out.println("Elector's Name :"+elc_name);
//                        System.out.println("Husband/Father Name :"+hus);
//                        System.out.println("House No. :"+house_num);
//                        System.out.println("EPIC No. :"+epic_num);
                        String b = "";
                        printer.append(b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+elc_name+";"+hus+";"+house_num+";"+epic_num);
                        printer.append("\n");
                    }
                    if(token.startsWith("Supplement No. : 1( )"))
                    {
                        while(fileIn.hasNextLine())
                        {
                            token2 = fileIn.nextLine();
                            //System.out.println("Token2 :"+token2);
                            if(token2.startsWith("House No:"))
                            {
                                int num = 1;
                                HashMap<Integer,String> hm = new HashMap<Integer,String>();
                                while(num<=9)
                                {
                                    hm.put(num, fileIn.nextLine());
                                    num++;
                                }
                                for(Map.Entry m:hm.entrySet())
                                {
                                    //System.out.println(m.getKey()+" "+m.getValue());
                                }
                                String elc_name = hm.get(9);
                                String hus = hm.get(8);
                                String house_num = hm.get(4);
                                String house_num1 = house_num.replace("Sex: Male", "");
                                String house_num2 = house_num1.replace("Sex: Female", "");
                                String epic_num = hm.get(2);
                                String epic_num1 = epic_num.replace("Elector's Name:", "");
//                                System.out.println("Elector's Name :"+elc_name);
//                                System.out.println("Husband/Father Name :"+hus);
//                                System.out.println("House No. :"+house_num);
//                                System.out.println("EPIC No. :"+epic_num);
                                String b = "";
                                printer.append(b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+b+";"+elc_name+";"+hus+";"+house_num2+";"+epic_num1);
                                printer.append("\n");
                            }
                        }
                    }
                }
                writer.close();
            }catch(Exception e){System.out.println("Exception3 :"); e.printStackTrace();}
        }
    }
}    
}
