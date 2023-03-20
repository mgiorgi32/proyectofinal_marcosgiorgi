export class persona{
    id?: number;
    nombre: String;
    apellido: String;
    descripcion: string;
    img: String;

    constructor(nombre: String, apellido: String, img: String, descripcion: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion= descripcion;
    }
}