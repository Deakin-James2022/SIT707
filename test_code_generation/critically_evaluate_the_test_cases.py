import unittest
from the_person_in_charge import Calculator

class TestCalculator(unittest.TestCase):
    def setUp(self):
        self.calc = Calculator()

    # test add()
    def test_add_positive(self):
        self.assertEqual(8, self.calc.add(5, 3))
    def test_add_negative(self):
        self.assertEqual(-8, self.calc.add(-5, -3))
    def test_add_zero(self):
        self.assertEqual(5, self.calc.add(0, 5))

    # test subtract()
    def test_subtract_positive(self):
        self.assertEqual(2, self.calc.subtract(5, 3))
    def test_subtract_negative(self):
        self.assertEqual(-2, self.calc.subtract(-5, -3))
    def test_subtract_zero(self):
        self.assertEqual(-5, self.calc.subtract(0, 5))
    def test_subtract_same(self):
        self.assertEqual(0, self.calc.subtract(10, 10))
if __name__ == "__main__":
    unittest.main()
