import sys
sys.path.append('./scripts/post_processing')

from plotnine import *
from VariableLoader import *
from evaluation import *
import math
# from pandasgui import show

"""
   File to plot experiments, basic functionality was left, but you should incude your own  
"""


def load_runtimes(folder):
    runtimes = pd.read_pickle(folder + 'runtimes.pickle')
    rename_location(runtimes)
    return runtimes


def load_summaries(folder):
    summaries = pd.read_pickle(folder + 'summaries.pickle')
    rename_location(summaries)
    return summaries


def load_summaries_normalized(folder):
    summaries_normalized = pd.read_pickle(folder + 'summaries_normalized.pickle')
    rename_location(summaries_normalized)
    return summaries_normalized


def rename_location(df):
    df.loc[df.location == -1, 'location'] = 'gmean'
    df['location'] = df.location.astype(str)


def split_column(df, column, new_titles):
    df[new_titles] = df[column].str.split(',', expand=True)


def merge_config_data(df1, configs, config_columns):
    return df1.merge(configs[config_columns], on='config')


def zoom_and_save(plot, ylims, file_name):
    for lim in ylims:
        p = plot
        if lim != 0:
            p = p + coord_cartesian(ylim=(1, lim))
        ggsave(p, file_name + '-lim{:02d}.pdf'.format(int(lim)), dpi=100)



if __name__ == '__main__':
    print('Write your code to plot the results of the experiment')
