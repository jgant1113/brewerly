import Main from './Components/Main/Main'
import {Provider} from 'react-redux'
import {BrowserRouter} from 'react-router-dom'
import {ConfigureStore} from './Redux/configureStore'
import BrewerySearch from './Components/BrewerySearch/BrewerySearch';



const store = ConfigureStore();

function App() {

  return (
    <Provider store={store}>
    <BrowserRouter>
    <Main/>
    </BrowserRouter>
    </Provider>
  )
}

export default App;

/* 
  to inspect certain components move return 
  items to here and then place the components to inspect into the
  return like this:
  

       <div>
    <BrewerySearch />


  </div>
   

   <Provider store={store}>
    <BrowserRouter>
    <Main/>
    </BrowserRouter>
    </Provider>
   
 
  */