import unittest

def palindrome_permutation(s):
    d = dict()
    s = s.lower()
    l = []
    for c in s:
        if c != " ":
            l.append(c)
    s = "".join(l)
    for c in s:
        if c in d:
            d[c] += 1
        else:
            d[c] = 1
    n_of_odds = 0
    for i in d.keys():
        if d[i] % 2 == 1:
            n_of_odds += 1
    if n_of_odds == 1 or n_of_odds == 0:
        print("It's a permutation of a palindrome.")
        return True
    else:
        print("It's not.")
        return False





class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ('Tact Coa', True),
        ('jhsabckuj ahjsbckj', True),
        ('Able was I ere I saw Elba', True),
        ('So patient a nurse to nurse a patient so', False),
        ('Random Words', False),
        ('Not a Palindrome', False),
        ('no x in nixon', True),
        ('azAZ', True)]

    def test_pal_perm(self):
        for [test_string, expected] in self.data:
            actual = palindrome_permutation(test_string)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()