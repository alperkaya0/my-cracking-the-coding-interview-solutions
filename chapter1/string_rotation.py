import unittest

def is_substring(s1, s2):
    return s1 in s2

def string_rotation(s1, s2):
    temp = s2 + s2
    print(is_substring(s1, temp) and len(s1) == len(s2) != 0)
    return is_substring(s1, temp) and len(s1) == len(s2) != 0

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ('waterbottle', 'erbottlewat', True),
        ('foo', 'bar', False),
        ('foo', 'foofoo', False),
        ('thisisatestcase', 'hisisatestcaset', True)
    ]

    def test_string_rotation(self):
        for [s1, s2, expected] in self.data:
            actual = string_rotation(s1, s2)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()