import { HttpEventType, HttpHandler, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Observable } from "rxjs";
import { TokenService } from "./token.service";

@Injectable({
    providedIn: 'root'
})
export class InterceptorService {
    constructor(private tokenService: TokenService){

        Intercept(req: HttpRequest<any>, next: HttpHandler):Observable<HttpEvent<any>>{
            let intReq = req;
            const token = this.tokenService.getToken();
            if(token != null){
                intreq = req.clone({
                    headers: req,headers.set('Authorization', 'bearer' + token)
                })
            }
            return Next.handle(intreq);

        }
    }
}

export const InterceptorProvider =[{
    provide: HTTP_INTERCEPTORS,
    useClass: InterceptorService,
    multi: true
}];
