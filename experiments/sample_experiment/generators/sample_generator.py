from baseGenerator import *

# EXPERIMENT SETUP FIELDS  
outputFile     = '../sample_experiment.csv'           # relative to this folder
experiment     = 'experiments/setups/sample_setup.xml' # relative to git root folder
group          = 'g1'
ratsPerConfig  = 100
rat_ids = [i for i in range(ratsPerConfig)]
numEpisodes    = 5;

    
# EXPERIMENT PARAMETERS
sample_str = ["string_1", "string_2"]
sample_int = [1, 5]


# GENERATE DATA FRAMES
experiment_DF = dataFrame('experiment',experiment)
group_DF      = dataFrame('group',group)
sample_str_DF = dataFrame('sample_str',sample_str)
sample_int_DF = dataFrame('sample_int',sample_int)        
ratIds_DF     = dataFrame('run_id',rat_ids)



##############################################################
#generate table
                             
#Combine tables
noRats = reduce(allXall , [experiment_DF, group_DF, sample_str_DF, sample_int_DF] )
noRats = createConfigColumn(noRats) # adds config name to each set of parameters
noRats['numEpisodes'] = numEpisodes

withRats = allXall(noRats,ratIds_DF);
saveResult(withRats,outputFile)
saveResult(noRats,'../sample_experiment_no_rats.csv')



            







