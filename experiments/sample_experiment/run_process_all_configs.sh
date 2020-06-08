#in git root folder execute the following commands:

SLURM_FILE="scripts/circe_cluster/configuration_process_results.sh"
PROCESSOR="experiments/sample_experiment/post_processing/processConfig.py"
LOG_FOLDER="experiments/sample_experiment/logs/"

sbatch -a 0-3 $SLURM_FILE $PROCESSOR ${LOG_FOLDER}sample_experiment/
