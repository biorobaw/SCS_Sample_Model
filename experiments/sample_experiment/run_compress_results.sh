#cd to folder
echo `pwd`
cd $1

# modify this file as needed, this file generates a zip file with the results

LOG_FOLDER="experiments/sample_experiment/logs"

#list of experiment folder
EXPERIMENTS=(
  # "experiment1-traces"
  "sample_experiment"
  # "experiment3-singleSame"
  # "experiment4-mazes"
  # "experiment5-single"
  # "experiment5-twoScales"
)

#create list of files to be compressed
FILES=""
for E in ${EXPERIMENTS[@]}; do
  [ -d "logs/$E/articlePlots/" ] && FILES="$FILES logs/$E/articlePlots/"
  FILES="$FILES $LOG_FOLDER/$E/experiments"
  FILES="$FILES $LOG_FOLDER/$E/mazes"
  FILES="$FILES $LOG_FOLDER/$E/cmdHistory.txt"
  FILES="$FILES $LOG_FOLDER/$E/configs.csv"
  FILES="$FILES $LOG_FOLDER/$E/runtimes.pickle"
  FILES="$FILES $LOG_FOLDER/$E/summaries.pickle"
  FILES="$FILES $LOG_FOLDER/$E/summaries_normalized.pickle"
done

tar -zcvf results.tar.gz $FILES


#cd to original folder
cd -


