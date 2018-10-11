Java Concurrency Examples
=================================

1. no01_threads - JustMain - one main thread, examine with debugger and pause thread. Most probably, it will be stopped at while waiting.
2. no02_threads_basics_deadlock_interrupt
    1. Basic: This is an example of how another thread can be interrupted and catch the Interrupted Exception.
    2. Deadlock: Simple example of an Deadlock.
3. no03_parallelworkers: Start starts several Workers. Visualization of switches between several threads.
4. no03_parallelworkers.withjoin: waits for individual threads both Start and Worker.
5. no04_account: Bank Account example, shows why ++ not being atomic can cause trouble.
6. no05_threadsafety: Simpler example showing the effect of ++ not atomic.
7. no06_lambda: little example with lambda

Puzzle (for the bored)
------------------------------------
With the last two examples, you might have noticed if the computation ends up wrong due to the missing
synchronization, this usually happens during the first couple of runs, and almost not anymore during the
last runs. Can you find an explanation for this behavior?
