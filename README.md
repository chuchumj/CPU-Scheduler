# CPU-Scheduler
CPU SCHEDULLING 
 
The main goal of CPU scheduling is to maximize CPU utilization in a multiprogramming environment. It aims at making the computer more productive by switching the CPU among processes. Once the CPU is idle the CPU scheduler must select a new process from the ready queue and allocate the CPU to it. In a single processor system, only one process can run at a time, others must wait until the CPU is free and can be rescheduled.  
 
TYPES OF CPU SCHEDULING 
 
All CPU scheduling fall under preemptive or non-preemptive scheduling. Sometimes, a combination of both are used in the algorithms like Round Robin algorithm. 
 
1. Preemptive scheduling: A CPU can decide which process to select that will run next on the CPU. This occurs when a process switches from the running state to the ready state or from the waiting state to the ready state.
2. Non-preemptive scheduling: Once the CPU has been scheduled to a process, the process keeps running on the CPU until it enters the waiting state or terminates thereby releasing the CPU. 
 
ROUND ROBIN CPU SCHEDULING 
 
Round Robin scheduling is a scheduling algorithm that uses the first come first serve scheduling, but preemption is also added to enable the CPU switch between processes. An amount of time called time quantum is defined and the CPU goes around the ready queue allocating the CPU to each process for a time interval up to 1 time quantum. If the time quantum is too large, the round robin scheduling degenerate into a FCFS policy, and if it’s too small the amount of context switch that will be done will be too large.  

PROJECT IMPLEMENTATION
 
The project is on a Round Robin CPU scheduling algorithm which takes processes from the ready queue on a first come first service basis and preemption is added to the scheduling algorithm that lets each process run for a time quantum, it then preempts it to allow another process to run in the CPU.  The file path and time quantum is inputted by the user once the program begins and if there are two processes with same arrival time, a first come first service policy is used to select a process to allocate the CPU to. 
 
The main class  The main class is used in getting the path to the csv file containing the process details and time quantum. It is also used for creating processes and CPU before calling the round robin method. The file path and time quantum are taken directly from the user through the scanner. It scans and assigns the process attributes process id, process arrival time, CPU burst time from the file, creates processes and puts them on a queue. An Arraylist data structure was selected as our queue because it is dynamic in size and maintains insertion order. A CPU scheduler is then created and this array of processes is passed to it through the constructor. 
 
Process class The Process class is dedicated for processes only, it has attributes process id, process arrival time, CPU burst time which were assigned from the file. It also has two additional attributes which are service time and completion time and contains a constructor for creating process.  
 
CPU Scheduling class The CPU scheduler class has an clock that keeps track of the overall time, a ReadyQueue that contains processes that are ready to run, an ArrayOfProcesses queue that contains all the processes, an endProcess queue that keeps track of all the 
processes that has finished execution, a running state that keeps track of which process that is in the CPU, a counter for keeping track of when a process has reach the given time quantum and a contextSwitch that keeps track of how many times a process has entered and left the runningState.  
 
The roundRobin method Once we are in the round robin method, the clock is set to 0. The program goes through all the processes and picks the ones that arrived at the same time and puts them in the ready queue, it then calls on CPU method. Upon entry into the CPU method it first checks if CPU is empty, if it is, it selects a process using the FIFO policy and puts it to run in the CPU. The counter keeps track of how long a process has been in the CPU and it’s reset back to 0 if the process runs for the given time quantum. The CPU method also keeps track to know when a process has completed its burst time so that it can return it to the endProcess queue and when it needs more time to run after executing for the given time quantum. After that, it calls the output method which is used to calculate our results and prints them out on the screen. It outputs the CPU utilization, turnaround time, average waiting time and average turnaround time. 
 
Output analysis Looking out the outputs for time quantum 1,3,5,7 and 9, as time quantum increases, the following happen: 1 The turnaround time decreases. Which is the time from the submission to completion of a process. 2 The average waiting time decreases. Which is the average amount of time a process spends waiting in the ready queue. 3 The throughput decreases. Which is the number of processes that are completed per unit time 4 CPU utilization also deceases.  As the time quantum keeps increasing, the round robin will degenerate to a FIFO policy and if it’s too small, the number of context switches will be too much. 
 
Time quantum 1: avgTurnAroundTime: 12.5 avgWaitingTime: 7.5 cpuUtilization: 29.99 throughput: 4.0 
 
Time quantum 3: avgTurnAroundTime: 12.5 avgWaitingTime: 7.5 cpuUtilization: 29.996 throughput: 1.0 
 
Time quantum 5: avgTurnAroundTime: 11.0 avgWaitingTime: 6.0 
