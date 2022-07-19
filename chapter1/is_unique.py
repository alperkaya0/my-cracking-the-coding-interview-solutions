def check_permutation(s1, s2):
    ls1 = {x for x in s1}
    ls2 = {x for x in s2}

    return("Permutation of each other." if ls1 == ls2 and len(s1) == len(s2) else "Not Permutation of each other.")

print(check_permutation("dog", "god"))
