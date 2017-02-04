export interface PlazaPropia {

    id : number;
    
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

export interface User {
    id: number;
    username: string;
    password: string;
    nombre: string;
    apellidos: string;
    email: string
    telefono: string
}