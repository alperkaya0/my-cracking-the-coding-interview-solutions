import unittest

def rotate_matrix(m):
    res = []
    for c in reversed(range(len(m))):
        res.insert(0, [])
        for r in range(len(m[c])):
            res[0].insert(0, m[r][c])
    print(res)
    return res

class Test(unittest.TestCase):
    '''Test Cases'''
    data = [
        ([
            [1, 2, 3, 4, 5],
            [6, 7, 8, 9, 10],
            [11, 12, 13, 14, 15],
            [16, 17, 18, 19, 20],
            [21, 22, 23, 24, 25]
        ], [
            [21, 16, 11, 6, 1],
            [22, 17, 12, 7, 2],
            [23, 18, 13, 8, 3],
            [24, 19, 14, 9, 4],
            [25, 20, 15, 10, 5]
        ]),
        (
            [
                [1,2,3],
                [10,20,30],
                [100,200,300]
            ],
            [
                [100,10,1],
                [200,20,2],
                [300,30,3]
            ]
        )
    ]

    def test_rotate_matrix(self):
        for [test_matrix, expected] in self.data:
            actual = rotate_matrix(test_matrix)
            self.assertEqual(actual, expected)

if __name__ == "__main__":
    unittest.main()