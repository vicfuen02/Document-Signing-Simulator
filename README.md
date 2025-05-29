
Proyecto construido con spring boot + Angular 17.


El proyecto consta de los siguientes endpoints: 

	/login : hace login del usuario
	/user : endpoint utiles para usuario (getAll, getById, createUser). Este endpoint no esta implementado en el front, 
			pero esta en la colección thunder que adjunto.
	/documents: endpoint para la subida y obtener los certificados subidos
	/sign: firma de un documento usado el certificado subido. Utiliza por defecto el primer certificado subido. Podría ampliarse la funcionalidad 
			permitiendo elegir cual certificado elegir para firmar.


Para control de login genero un string (token) que seteo en los headers y guardo en una instancia de Cache para en las siguientes llamadas, mediante un interceptor, compruebo si ese token existe y asi recuperar que usuario es el logeado. También añado una variable de configuracion (allow.notLoggedUsers) para activar o desactivar esta opción ya que en el front no he llegado a implementar la funcionalidad de mandar este token en los headers.

Añado una primera implementación de arquitectura multitenant en el paquete  que lee la configuración de la base de datos de los ficheros de configuración resources/tenantsDB (path configurable en el application.properties). Actualmente para elegir que tenant se elige se debe asignar en los headers de antemano el nombre del tenant (tenant1 o tenant2). Esta pensado asi para poder asignar por configuración en el front el tenant y elegir la bd en cada implantación de cliente. Por defecto se escoge el tenant1, también seteado en la colección thunder aun que no en el front.


Adjunto dos scripts de BD con un par de usuarios registrados y un certificado para cada tenant.


Para la parte front consta de una pantalla inicial con un link que te lleva a la pantalla de login. Una vez logado con existo te redirige a la pantalla de certificados del usuario donde se permité subir un certificado y automaticamente refresca el listado de certificados del usuario. También existe el botón que permite subir y firmar un documento, mostrando en pantalla el certificado en base64 con la firma escrita en el backend.


