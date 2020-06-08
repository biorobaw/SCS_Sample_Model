#in git root folder execute the following commands:

CHECK="scripts/post_processing/MissingFiles.py"
LOG_FOLDER="experiments/sample_experiment/logs/"

#we will assume there were no errors if the following file is present for all rats for all configs (#ID will be replaced by the rat ids)
FILE="r#ID-steps.bin"
NUM_RATS=100

echo ""
echo "E2"
python $CHECK ${LOG_FOLDER}sample_experiment/  $FILE $NUM_RATS
