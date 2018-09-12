// process
class Process {
     int processId;
     int processArrivalTime;
     int cpuBurstTime;
    double serviceTime ;
    double completionTime;
     public Process(int processId,int processArrivalTime,int cpuBurstTime ){
         this.processId = processId;
         this.processArrivalTime =processArrivalTime;
        this.cpuBurstTime= cpuBurstTime;
        serviceTime = 0;
     }



}
