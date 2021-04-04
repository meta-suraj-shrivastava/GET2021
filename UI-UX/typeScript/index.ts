import express from 'express'
import { readFile } from 'fs';

const app = express();
const PORT = 8080;
app.get('/',(req,res)=>{
    res.writeHead(200, {
        'Content-Type': 'text/html'
    });
    readFile('./index.html', null, function (error, data) {
        if (error) {
            res.writeHead(404);
            res.write('Whoops! File not found!');
        } else {
            res.write(data);
        }
        res.end();
    })
}
).listen(PORT,()=>console.log("Listening at port ",PORT));
