import os

#First A is a latin A, second is a cyrillic A
magic_ingredients = ['A','А']
substitution_dict = {}

#Generates a substitution dictionary and magic.h
count = 0
with open('symbols.txt','r') as symbols:
    with open('magic.h','w') as magic_h:
        symbol = symbols.readline()                 
        while symbol:
            pattern = '{0:08b}'.format(count) #Converts count to binary
            substitution = ""
            for c in pattern:
                substitution = substitution + magic_ingredients[int(c)] #0->Latin, 1->Cyrillic
            model = "#define {} {}"
            magic_h.write(model.format(substitution,symbol))
            substitution_dict[symbol.rstrip()] = substitution
            count = count + 1
            symbol = symbols.readline();
to_write_magic = ""

#Magic happens here
string_delimiter = 0 #If 1 : we're in a string
with open('main.c','r') as main_c:
    for main_line in main_c:
        if "#include" in main_line: #So as to not break includes
            to_write_magic = to_write_magic + main_line
        else:
            for word in main_line.split():
                string_delimiter = (string_delimiter + word.count("\""))%2
                if word in substitution_dict and string_delimiter < 1: #If we're not in a string, apply magic
                    word = substitution_dict[word]
                to_write_magic = to_write_magic + word + " "
with open('magic.c','w') as magic_c:
    magic_c.write(to_write_magic)

#Compiles our magic code
os.popen("gcc magic.c")


                                        
