import unittest

def zero_matrix(m):
    target_rows = set()
    target_cols = set()
    for r in range(len(m)):
        for c in range(len(m[r])):
            if m[r][c] == 0:
                target_rows.add(r)
                target_cols.add(c)
    for r in range(len(m)):
        for c in range(len(m[r])):
            if r in target_rows:
                m[r][c] = 0
            if c in target_cols:
                m[r][c] = 0
    return m

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ([
            [1, 2, 3, 4, 0],
            [6, 0, 8, 9, 10],
            [11, 12, 13, 14, 15],
            [16, 0, 18, 19, 20],
            [21, 22, 23, 24, 25]
        ], [
            [0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0],
            [11, 0, 13, 14, 0],
            [0, 0, 0, 0, 0],
            [21, 0, 23, 24, 0]
        ])
    ]

    def test_zero_matrix(self):
        for [test_matrix, expected] in self.data:
            actual = zero_matrix(test_matrix)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()