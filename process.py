# script for automating the generation of README.md
# created by: Yu Geng
# 2020-09-10

fin  = open('input.md', 'r')
fout = open('output.md', 'w')

raw = fin.readline()
while raw != "":
    record = raw.strip().split('|')
    problem, level = record[1], record[-2]
    rearrange = '|'.join([problem, level])
    fout.write('|' + rearrange + '|\n')
    raw = fin.readline()  # read the next line

fin.close()
fout.close()
