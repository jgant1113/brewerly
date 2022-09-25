import { useEffect, useState } from "react";
import axios from 'axios';
import Beer from "../Beer/Beer";


export default function Menu(props){
    const [beers, setBeers] = useState([]);

    useEffect(() =>{
        fetchData();
        console.log(beers);
            
    }, [])

function fetchData(){
    // axios.get(`http://localhost:8081/beer/getAll/${props.brewery}`)
    // .then((data) => data.json())
    // .then(list => console.log(list))
     fetch(`http://localhost:8081/beer/getAll/${props.brewery}`)
             .then((response) => response.data())
             //setBeers here
             .then((result) => setBeers(result))
             .catch((error) => console.error('Error:', error))
}

    return(
        <ul>
            {beers.map((beer,key) =>{
                return (
                    //Change this to a Beer component
                    <li>
                        <Beer beer = {beer} key = {key} />
                    </li>
                    )
            })}
        </ul>
    )
}