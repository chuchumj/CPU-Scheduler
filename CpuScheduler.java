import java.util.ArrayList;
// round robin
public class CpuScheduler {
    int clock;         // keeps track of overall time
    ArrayList<Process> endProcess;
    ArrayList<Process> arrayOfProcesses;
    ArrayList<Process> readyQueue;
    int timeQuantum;
    Process runningState;
    int counter = 0; // keeps track of how many times the process when in and out of cpu(running)
    int contextSwitch;


    public CpuScheduler(int timeQuantum, ArrayList arrayOfProcesses) {
        this.timeQuantum = timeQuantum;
        this.arrayOfProcesses = arrayOfProcesses;
    }

    public void roundRobin() {
       contextSwitch = 0;
        runningState = null;
        endProcess = new ArrayList<>();
        readyQueue = new ArrayList<>();
        clock = 0;

        while (!readyQueue.isEmpty() || runningState != null || !arrayOfProcesses.isEmpty()) {
            for (int i = 0; i < arrayOfProcesses.size(); i++) {

                if (arrayOfProcesses.get(i).processArrivalTime == clock) { // for each loop, we are getting the processes that arrive at same time
                    readyQueue.add(arrayOfProcesses.remove(i));//
                }
            }   Cpu();
        }       Output();
    }

    public void Cpu() {

        if (runningState == null) { // if cpu is empty, put the process at index 0 into the cpu to run
            runningState = readyQueue.remove(0); // gave runningState the reference to the process

        }
        counter++;                  // counter used to keep track of how long the process was in the cpu
        runningState.serviceTime++; // you use the service time os the process then increase it

        if (runningState.cpuBurstTime == runningState.serviceTime) {// each process that completes its burst time is sent to endprocess queue
            runningState.completionTime = clock;                    // check if that process service time == to its burst time
            endProcess.add(runningState);
            runningState = null;
            contextSwitch++;
            counter = 0;
        } else if (counter == timeQuantum) {// when its not done running for the time quantum,it is sent back yo the ready queue
            readyQueue.add(runningState);
            runningState = null;
            contextSwitch++;
            counter = 0;
        }
        clock++;
    }

    public void Output() {
        double totalTurnAroundTime = 0;
        double sumWaitingTime = 0;
        double processUtilizedTime = 0;
        for (int i = 0; i < endProcess.size(); i++) {
             totalTurnAroundTime += endProcess.get(i).completionTime - endProcess.get(i).processArrivalTime;
            sumWaitingTime += endProcess.get(i).completionTime - endProcess.get(i).processArrivalTime - endProcess.get(i).cpuBurstTime;
            processUtilizedTime += endProcess.get(i).cpuBurstTime;
        }
        double avgTurnAroundTime = totalTurnAroundTime / endProcess.size();
        double avgWaitingTime = sumWaitingTime / endProcess.size();
        double cpuUtilization = sumWaitingTime - (contextSwitch * .01) / clock ;
        double throughput = endProcess.size() / timeQuantum;

        System.out.println("avgTurnAroundTime: " + avgTurnAroundTime);
        System.out.println("avgWaitingTime: " + avgWaitingTime);
        System.out.println("cpuUtilization: " + cpuUtilization);
        System.out.println("throughput: " + throughput);

    }

}








