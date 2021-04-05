import express from 'express'
import { readFile } from 'fs';
import path from 'path';


const app = express();
const PORT = 8080;

app.use('/static', express.static(path.join(__dirname, 'assets')));
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
    });
}
).listen(PORT,()=>console.log("Listening at port ",PORT));
