#in git root folder execute the following commands:

RUN_ALL="scripts/circe_cluster/run_all_batches.sh"
EXPERIMENT_FOLDER="experiments/sample_experiment/"
LOG_FOLDER=${EXPERIMENT_FOLDER}logs

sh $RUN_ALL ${EXPERIMENT_FOLDER}/sample_experiment.csv ${LOG_FOLDER}sample_experiment 100
