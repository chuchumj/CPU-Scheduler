import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path");
        String path = scanner.nextLine();
        System.out.println(" Enter the time quantum you want");
        int timeQuantum = scanner.nextInt();

        File file = new File(path);
        FileReader filereader ;
        ArrayList<Process> arrayOfProcesses = new ArrayList<Process>();//  create an empty arrayList that increases and shrinks in size

        try{
                filereader = new FileReader(file);// gets file name from string object and opens the file in read mode
                scanner = new Scanner(filereader).useDelimiter( ",|\\v+");// scanner scans the input by breaking them into tokens
                scanner.nextLine();
                while(scanner.hasNext()){
                  int processId  = scanner.nextInt();
                  int processArrivalTime = scanner.nextInt();
                  int cpuBurstTime = scanner.nextInt();
                    Process process = new Process(processId, processArrivalTime,cpuBurstTime);// created the processes
                    arrayOfProcesses.add(process);
                }
        }catch( FileNotFoundException e){
            System.out.println("could not read file");
        }
        scanner.close();

        CpuScheduler cpuscheduler = new CpuScheduler(timeQuantum, arrayOfProcesses);
        cpuscheduler.roundRobin();
    }
}
