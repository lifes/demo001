#### when deploy to Linux Server do:
    1. crontab -l // check the task list.
    2. crontab -e 
       add: 0 1 * * * ~/app/xty-scheduler-task-1.0/bin/xty-scheduler-task
    3. Notice that the path you exec command 'crontab -e' will affect the log file location. So if you at ~, please see the logs at ~/logs/xty-scheduler-task.log & red.log
