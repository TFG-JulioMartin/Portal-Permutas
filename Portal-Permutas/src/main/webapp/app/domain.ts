export interface PlazaPropia {

    id : string;
    titulo : string;
    ciudad : string;
    centro : string;
    direccion : string;
    latitud : number;
    longitud : number;
    usuarioId : string;
    
}

export interface ZonaDeseada {

    id : string;
    latitud : number;
    longitud : number;
    radio : number;
    usuarioId : string;
    
}

export interface ZonaDeseadaDTO {

    slat : number;
    slng : number;
    elat : number;
    elng : number;   
    usuarioId : string;
    
}

export interface Coincidencia {

    id : string;
    idDestinatario: string;
    titulo : string;
    nombre : string;
    
    
}

export interface Propuesta {

    id : string;
    titulo : string;
    texto : string;
    estado: number;
    remitenteId : string;
    destinatarioId : string;
    fecha : string
    fechaAcepRech : string;   
    
}

export interface PropuestaDTO {

    id : string;
    titulo : string;
    texto : string;
    estado: number;
    nombreRemitente : string;
    nombreDestinatario : string;
    fecha : string
    fechaAcepRech : string;   
    idRemitente : string;
	latitudRemitente : number;
	longitudRemitente : number;
    
}

export interface User {
    id: number;
    username: string;
    password: string;
    confirm: string;
    nombre: string;
    apellidos: string;
    email: string;
    telefono: string;
}

export interface UserForm {
    id: number;
    username: string;
    password: string;
    nombre: string;
    apellidos: string;
    email: string;
    telefono: string;
    titulo : string;
    ciudad : string;
    centro : string;
    direccion : string;
    latitud : number;
    longitud : number;
}