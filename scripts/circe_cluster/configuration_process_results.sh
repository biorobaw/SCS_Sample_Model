#!/bin/bash

#SBATCH --time=0:10:00
#SBATCH --cpus-per-task 2
#SBATCH --qos=preempt
#SBATCH --mem=2000M
#SBATCH -p mri2016

processor_file=$1
baseDir=$2
configId=c$SLURM_ARRAY_TASK_ID

echo "configId " $configId

module rm apps/python/3.7.0
module add apps/python/3.7.3
PYTHONUSERBASE=/home/p/pablos/work/pythonlibs


python $processor_file $baseDir $configId


if [ $? -eq 0 ]; then
    echo SUCCESS
else
    echo "FAIL $baseDir $configId"
fi
