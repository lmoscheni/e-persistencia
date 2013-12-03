from pycassa import *
from pickle import *
import random

class Connection_DB:
	
	def __init__(self , pol , col):
		self.pool = ConnectionPool(pol)
		self.column = ColumnFamily(self.pool , col)

	#Este metodo se debe redefinir para cada clase en particular
	def save(self , user):
		self.column.insert(user.get_name(),{	'name': user.get_name(),
												'pictures': dumps([]),
												'friends': dumps([]),
												'lost' : str(random.randrange(10)),
												'won' : str(random.randrange(10)),
												'draw' : str(random.randrange(10))
								 		   })

	#Este metodo, asocia (key -> an_object), a la vez an_Object es parte "de un tipo
	# de columna dado"
	def put_in_the_column(self , key , column_name , an_object , serializable=False):
		element = None
		if(serializable):
			element = dumps(an_object)
		else:
			element = an_object

		self.column.insert(key , {column_name : element})

	#Este metodo dado un key, te retorna el valor asociado para ese key, en una
	#columna determinada
	def get_column(self , key , an_column , serializable=False):
		element = None
		if(serializable):
			element = loads(self.column.get(key)[an_column])
		else:
			element = self.column.get(key)[an_column]

		return element


	#Este metodo borra todos los datos de la BD
	def resetBD():
		self.column.truncate()