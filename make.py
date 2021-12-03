import os
import random

#First A is a latin A, second is a cyrillic A
magic_ingredients = ['A','А']
substitution_dict = {}

#Generates a substitution dictionary and magic.h
symbol_count = 1 # We start at 1 so we can safely name stuff in our code with latin As
template = "#define {} {}"
with open('symbols.txt','r') as symbols:
    with open('magic.h','w') as magic_h:
        symbol = symbols.readline()                 
        while symbol:
            pattern = '{0:08b}'.format(symbol_count) #Converts count to binary
            substitution = ""
            for c in pattern:
                substitution = substitution + magic_ingredients[int(c)] #0->Latin, 1->Cyrillic
            magic_h.write(template.format(substitution,symbol))
            substitution_dict[symbol.rstrip()] = substitution
            symbol_count = symbol_count + 1
            symbol = symbols.readline();

#Shuffling operation section for extra cancer
section_begin = 4
main_array = []
with open('main.c','r') as main_c:
    main_array = [x for x in main_c.read().split('\n') if not "//" in x] #Read original file and puts it in array without comment lines
section_end = len(main_array) - 1
main_sub_arrays = [main_array[i:i + 3] for i in range(section_begin, section_end, 3)] #Split into instruction sections (identifier, code, goto)
random.Random(0xF15A4).shuffle(main_sub_arrays) #Shuffling
main_new_array = [item for sublist in main_sub_arrays for item in sublist] #Flattening the list
main_array[4:len(main_array) - 1]=main_new_array #Replacing old code with new shuffled code

#Magic happens here
to_write_magic = ""
word_count = 0
words_per_line = 12
string_delimiter = 0 #If 1 : we're in a string
for main_line in main_array:
    if "#include" in main_line: #So as to not break includes
        to_write_magic = to_write_magic + main_line + "\n"
    else:
        for word in main_line.split():
            string_delimiter = (string_delimiter + word.count("\""))%2
            if string_delimiter < 1 : #If we're not in a string, apply magic
                if word in substitution_dict:
                    word = substitution_dict[word]
                word_count = (word_count + 1) % words_per_line
            to_write_magic = to_write_magic + word + ("\n" if word_count == words_per_line - 1 and string_delimiter < 1 else " ")
with open('magic.c','w') as magic_c:
    magic_c.write(to_write_magic)

#Compiles our magic code
os.popen("gcc magic.c")


                                        
