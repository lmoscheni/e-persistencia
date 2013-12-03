from connectionDB import *

class User:
	db_connection = Connection_DB("pugpe","encontroxvi")
	
	def __init__(self, name, email):
		self.name = name
		self.email = email
		#Persistir datos en DB
		self.db_connection.save(self)
	
	'''
			Getters
	'''
	def get_name(self):
		return self.name

	def get_email(self):
		return self.email

	def get_pictures(self):
		return (self.db_connection.get_column(self.get_name() , 'pictures' , True))

	def get_friends(self):
		return (self.db_connection.get_column(self.get_name() , 'friends' , True))

	def get_games_lost(self):
		return (self.db_connection.get_column(self.get_name() , 'lost'))

	def get_games_won(self):
		return (self.db_connection.get_column(self.get_name() , 'won'))

	def get_games_draw(self):
		return (self.db_connection.get_column(self.get_name() , 'draw'))

	
	'''
			Setters
	'''
	def set_pictures(self, ls):
		self.db_connection.put_in_the_column(self.get_name() ,'pictures' , ls , True)

	def set_friends(self, ls):
		self.db_connection.put_in_the_column(self.get_name() ,'friends' , ls , True)

	
	'''
			Funciones para poder visualizar la en consola la lista de amigos y fotos
	'''
	def print_friends(self):
		return (pass_to_name(self.db_connection.get_column(self.get_name() , 'friends' , True)))

	def print_pictures(self):
		return (pass_to_name(self.db_connection.get_column(self.get_name() , 'pictures' , True)))

	'''
			Funciones de Negocio
	'''

	# Explicacion:
	# supongamos que tenemos a los usuarios A, B, C, D y E
	# A tiene una lista de amigos que es [B, C]
	# B tiene una lista de amigos que es [D]
	# D tiene una lista de amigos que es [E]
	# C tiene una lista de amigos []
	# si hacemos:
	# A.get_friends_level_3() esta nos retornara: [B,C,D,E] -> tiene 3 niveles de anidamiento
	# B.get_friends_level_3() esta nos retornara: [D,E] -> tiene 2 niveles de anidamiento
	# La funcion como maximo trae hasta tres niveles de anidamiento, en caso de que lo haya.
	def get_friends_level_3(self):
		resulset = []
		first_Level_List = self.get_friends()
		resulset.extend(first_Level_List)
		second_Level_List= self._get_friends_to_list(first_Level_List)
		resulset.extend(second_Level_List)
		three_Level_List = self._get_friends_to_list(second_Level_List)
		resulset.extend(three_Level_List)
		return resulset


	# Esta funcion dada una lista de amigos, retorna la lista conformada por
	# los amigos de mis amigos.
	def _get_friends_to_list(self, ls):
		resulset = []
		for x in ls:
			resulset.extend(x.get_friends())

		return resulset