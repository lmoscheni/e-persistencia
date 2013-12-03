'''
		FUNCIONES HELPER
'''
# Funcion que ~serializacion() sobre los elementro de una lista
def pass_to_name(ls):
	ret = []
	for e in ls:
		ret.append(e.get_name())
	return ret