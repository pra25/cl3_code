import unittest
from quicksort import *

class Mytest(unittest.TestCase):
	def testfun(self):
		try:
			a = getdata('input.xml')
			if a==None:
				self.fail('failed')
		except:
			self.fail('Failed... Cannot Load file')

	def testfun1(self):
		self.assertEqual(getdata('input.xml'), [23, 2, 21])

unittest.main()
        
