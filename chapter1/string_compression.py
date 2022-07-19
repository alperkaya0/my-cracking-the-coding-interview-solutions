import unittest

def string_compression(s):
    l = []
    temp = s[0]
    count = 0
    for c in s:
        if c == temp:
            count += 1
        if c != temp:
            l.append(temp)
            l.append(str(count))
            temp = c
            count = 1
    l.append(temp)
    l.append(str(count))
    res = "".join(l)
    if len(s) <= len(res):
        return s
    return res

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ('aabcccccaaa', 'a2b1c5a3'),
        ('abcdef', 'abcdef'),
        ('uuuuubbdeeeefg', 'u5b2d1e4f1g1')
    ]

    def test_string_compression(self):
        for [test_string, expected] in self.data:
            actual = string_compression(test_string)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()