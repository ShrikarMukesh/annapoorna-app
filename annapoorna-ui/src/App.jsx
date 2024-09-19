import {
    Route,
    createBrowserRouter,
    createRoutesFromElements,
    RouterProvider,
} from 'react-router-dom';

import NotFound from "./pages/NotFound.jsx";
import MainLayout from "./layouts/MainLayout.jsx";
import HomePage from "./pages/HomePage.jsx";
import JobsPage from "./pages/JobsPage.jsx";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

const router = createBrowserRouter(
    createRoutesFromElements(
        <Route path='/' element={<MainLayout/>}>
            <Route index element={<HomePage/>}/>
            <Route path = '/jobs' element={<JobsPage/>}/>
            <Route path='*' element={<NotFound/>}/>
        </Route>
    )
)
const App = () =>{
   return(
         <RouterProvider router={router}/>
   )
};

export default App;