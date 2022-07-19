import unittest

def single_pass(s1, s2):
    #Check lengths so that we won't compute on something wrong from the start(and possibly end up with false positives-negatives)
    if len(s1) - 1 == len(s2) or len(s1) == len(s2) - 1 or len(s1) == len(s2):
        #I ASSUMED THAT STRINGS ARE ENCODED WITH ASCII
        s1_ascii_table = [0 for x in range(128)]
        s2_ascii_table = [0 for x in range(128)]
        for c in s1:
            s1_ascii_table[ord(c)] += 1
        for c in s2:
            s2_ascii_table[ord(c)] += 1
        n_of_diff = 0
        for i in range(128):
            if s1_ascii_table[i] != s2_ascii_table[i]:
                n_of_diff += 1
        if n_of_diff <= 2:#If one more or less, n_of_diff will be 1. If one character different, then n_of_diff will be 2. If nothing changes(zero operation case) then n_of_diff will be 0.
            return True
        else:
            return False
    else:
        return False




class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ('pale', 'ple', True),
        ('pales', 'pale', True),
        ('pale', 'bale', True),
        ('paleabc', 'pleabc', True),
        ('pale', 'ble', False),
        ('a', 'b', True),
        ('', 'd', True),
        ('d', 'de', True),
        ('pale', 'pale', True),
        ('pale', 'ple', True),
        ('ple', 'pale', True),
        ('pale', 'bale', True),
        ('pale', 'bake', False),
        ('pale', 'pse', False),
        ('ples', 'pales', True),
        ('pale', 'pas', False),
        ('pas', 'pale', False),
        ('pale', 'pkle', True),
        ('pkle', 'pable', False),
        ('pal', 'palks', False),
        ('palks', 'pal', False)
    ]

    def test_one_away(self):
        for [test_s1, test_s2, expected] in self.data:
            actual = single_pass(test_s1, test_s2)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()
