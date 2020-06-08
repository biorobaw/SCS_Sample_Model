#in git root folder execute the following commands:

RUN_ALL="experiments/sample_experiment/post_processing/processAllConfigs.py"
LOG_FOLDER="experiments/sample_experiment/logs/"

module add apps/python/3.7.3

# python $RUN_ALL ${LOG_FOLDER}experiment1-traces/
python $RUN_ALL ${LOG_FOLDER}sample_experiment/
# python $RUN_ALL ${LOG_FOLDER}experiment3-singleSame/
# python $RUN_ALL ${LOG_FOLDER}experiment4-mazes/
# python $RUN_ALL ${LOG_FOLDER}experiment5-single/
# python $RUN_ALL ${LOG_FOLDER}experiment5-twoScales/